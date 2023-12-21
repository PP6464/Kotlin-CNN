import layers.DenseLayer
import layers.InputLayer
import layers.OutputLayer
import model.Sequential
import org.jetbrains.kotlinx.multik.api.mk
import org.jetbrains.kotlinx.multik.api.ndarray
import kotlin.time.measureTime

fun main() {
	val timeTaken = measureTime {
		val model = Sequential(
			layers = listOf(
				InputLayer(
					shape = listOf(9, 9),
				),
				DenseLayer(16),
				DenseLayer(16),
				OutputLayer(
					size = 10,
					outputs = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
				),
			)
		)
		println(
			model.run(
				input = mk.ndarray(
					mk[
						mk[1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0],
						mk[1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0],
						mk[1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0],
						mk[1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0],
						mk[1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0],
						mk[0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0],
						mk[0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0],
						mk[0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0],
						mk[1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0],
					]
				), // Tests for a 5
			)
		)
	}
	print(timeTaken)
}