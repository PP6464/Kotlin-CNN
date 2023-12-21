package layers

import helper.*
import org.jetbrains.kotlinx.multik.ndarray.data.Dim2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray
import org.jetbrains.kotlinx.multik.ndarray.operations.toList

/**
 * A class to model an input layer
 * @param shape: The shape of the input
 * @param activations: The activations of the input (can be null by default) (must be 2D if supplied)
 */
data class InputLayer(
	val shape : List<Int>,
	override var activations : List<Double> = emptyActivations(shape.map(Int::toDouble).multiplyAll().toLong()),
) : Layer {
	override val size : Long
		get() = shape.map(Int::toDouble).multiplyAll().toLong()
	
	/**
	 * A method to set the input activations as they may not be known at construction time
	 * @param activations: The activations of the input (only 2D input for now)
	 */
	override fun set2DActivations(activations : NDArray<Double, Dim2>) {
		this.activations = activations.flatten().toList()
	}
}
