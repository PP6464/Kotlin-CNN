package layers

import org.jetbrains.kotlinx.multik.ndarray.data.Dim2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray

/**
 * Abstract class for a layer
 * @property size: The number of nodes in the layer
 * @property activations: The activations of each node
 * @property setActivations: A method to set activations
 *  (if they are not known at construction time or need modification)
 */
interface Layer {
	val size : Long
	var activations : List<Double>?
	fun setActivations(activations : NDArray<Double, Dim2>)
}