package layers

import org.jetbrains.kotlinx.multik.ndarray.data.Dim2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray

/**
 * Abstract class for a layer
 * @property size: The number of nodes in the layer
 * @property set2DActivations: The activations of each node
 * @property set2DActivations: A method to set activations
 *  (if they are not known at construction time or need modification)
 */
interface Layer {
	val size : Long
	var activations : List<Double>
	fun set2DActivations(activations : NDArray<Double, Dim2>)
}