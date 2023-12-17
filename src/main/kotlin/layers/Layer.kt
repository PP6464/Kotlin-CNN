package layers

import org.jetbrains.kotlinx.multik.ndarray.data.Dim2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray

interface Layer {
	val size: Long
	fun setActivations(activations: NDArray<Int, Dim2>)
}