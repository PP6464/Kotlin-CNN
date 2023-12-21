package model

import helper.*
import layers.*
import org.jetbrains.kotlinx.multik.ndarray.data.*
import java.io.*
import kotlin.math.sqrt
import kotlin.random.Random

/**
 * A class to model a Sequential neural network (a sequence of layers, hence the name)
 * It is serializable so that it can be saved to and loaded from a file
 * @param: layers The layers of the model
 */

data class Sequential(val layers : List<Layer>) : Serializable {
	// weights contains a list for each layer pair, and each layer pair contains a list for each node of the second layer in the pair.
	// Each double in the list for each node is the weight of the connection from the corresponding first node to the corresponding second node.
	private val weights = mutableListOf<List<List<Double>>>()
	
	// biases contains a list for each layer, where each element in the list is bias for that node
	private val biases = mutableListOf<List<Double>>()
	
	init {
		assert(layers.first() is InputLayer)
		assert(layers.last() is OutputLayer)
		for (layerPair in layers.zipWithNext()) {
			weights
				.add(
					(0..<layerPair.second.size).map {
						(0..<layerPair.first.size).map {
							Random.nextDouble(
								-sqrt(6.0 / (layerPair.first.size + layerPair.second.size)),
								sqrt(6.0 / (layerPair.first.size + layerPair.second.size))
							)
						}
							.toMutableList()
					}
				)
		} // Xavier Glorot weights initialization
		for (layer in layers) {
			biases += emptyActivations(layer.size) // Can use the same initialization to set biases to full of 0s
		}
	}
	
	/**
	 * A function to save the model to a file
	 * @param path The path of the file to save the model to
	 */
	fun save(path : String) {
		ObjectOutputStream(FileOutputStream(path)).use {
			it.writeObject(this)
		}
	}
	
	/**
	 * A function that takes an input and outputs a prediction from the neural network
	 * @param input The input activation
	 * @param returnIndex Whether to return the index of the output node or the label of the output node (index used for training)
	 */
	fun run(input : D2Array<Double>, returnIndex : Boolean = false) : Any {
		layers[0].set2DActivations(input)
		for (layerIndex in 1..<layers.size) {
			val activations = mutableListOf<Double>()
			repeat(layers[layerIndex].size.toInt()) { nodeIndex ->
				var total = 0.0
				val bias = biases[layerIndex][nodeIndex]
				repeat(layers[layerIndex - 1].size.toInt()) { prevLayerNodeIndex ->
					val weight = weights[layerIndex - 1][nodeIndex][prevLayerNodeIndex]
					total += weight * layers[layerIndex - 1].activations[prevLayerNodeIndex]
				}
				total += bias
				activations += sigmoid(total)
			}
			layers[layerIndex].activations = activations
		}
		val maxActivationNodeIndex = layers.last().activations.withIndex().maxBy { it.value }.index
		return if (returnIndex) maxActivationNodeIndex else (layers.last() as OutputLayer).outputs[maxActivationNodeIndex]
	}
	
	companion object {
		/**
		 * A function to load the model from a file
		 * @param path The path of the file to load the model from
		 */
		fun load(path : String) = ObjectInputStream(FileInputStream(path)).use { it.readObject() as Sequential }
	}
}
