package layers

import helper.*
import org.jetbrains.kotlinx.multik.ndarray.data.Dim2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray
import org.jetbrains.kotlinx.multik.ndarray.operations.toList

/**
 * A class to model an output layer
 * @param size: The number of output nodes
 * @param activations: The activations of the layer (can be null by default)
 * @param outputs: The label of each output node (a list of labels, the index of the label is the index of the corresponding node)
 */
data class OutputLayer(
	override val size: Long,
	override var activations : List<Double> = emptyActivations(size),
	val outputs: List<String>,
) : Layer {
	override fun set2DActivations(activations : NDArray<Double, Dim2>) {
		this.activations = activations.flatten().toList()
	}
}
