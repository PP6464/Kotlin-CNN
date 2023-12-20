package model

import layers.*
import java.io.Serializable

/**
 * A class to model a Sequential neural network (a sequence of layers, hence the name)
 * It is serializable so that it can be saved to and loaded from a file
 * @param: layers: The layers of the model
 */

data class Sequential(val layers : List<Layer>) : Serializable {
	// weights contains a list for each layer pair, and each layer pair contains a list for each node of the second layer in the pair.
	// Each int in the list is the weight of the connection from the corresponding first node to the corresponding second node.
	val weights = mutableListOf<List<Int>>()
	
	// biases contains a list for each layer, where each element in the list is bias for that node
	val biases = mutableListOf<List<Int>>()
	
	init {
		assert(layers.first() is InputLayer)
		assert(layers.last() is OutputLayer)
		for (layerPair in layers.zipWithNext()) {
		}
	}
}
