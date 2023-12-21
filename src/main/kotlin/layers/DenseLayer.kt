package layers

import helper.emptyActivations
import org.jetbrains.kotlinx.multik.ndarray.data.D2Array
import org.jetbrains.kotlinx.multik.ndarray.operations.toList

/**
 * A class used to model a dense layer in a neural network
 * @param size The number of nodes in the layer
 * @param activations The activations of the layer (can be null by default)
 */
data class DenseLayer(
	override val size : Long,
	override var activations : List<Double> = emptyActivations(size),
) : Layer {
	override fun set2DActivations(activations : D2Array<Double>) {
		this.activations = activations.flatten().toList()
	}
}
