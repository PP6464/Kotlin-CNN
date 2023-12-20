package layers

import org.jetbrains.kotlinx.multik.ndarray.data.Dim2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray
import org.jetbrains.kotlinx.multik.ndarray.operations.toList

/**
 * A class used to model a dense layer in a neural network
 * @param size: The number of nodes in the layer
 * @param activations: The activations of the layer (can be null by default)
 */
data class DenseLayer(
	override val size: Long,
	override var activations : List<Double>,
) : Layer {
	override fun setActivations(activations : NDArray<Double, Dim2>) {
		this.activations = activations.flatten().toList()
	}
}
