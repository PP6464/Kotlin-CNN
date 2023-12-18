package layers

import helper.multiplyAll
import org.jetbrains.kotlinx.multik.ndarray.data.Dim2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray
import org.jetbrains.kotlinx.multik.ndarray.operations.toList

/**
 * A class to model an input layer
 * @param shape: The shape of the input
 * @param activations: The activations of the input (can be null by default)
 */
data class InputLayer(
	val shape : List<Int>,
	override var activations : List<Double>? = null,
) : Layer {
	override val size : Long
		get() = shape.map(Int::toDouble).multiplyAll().toLong()
	
	/**
	 * A method to set the input activations as they may not be known at construction time
	 */
	override fun setActivations(activations : NDArray<Double, Dim2>) {
		this.activations = activations.flatten().toList()
	}
}
