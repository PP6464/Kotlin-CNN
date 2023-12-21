package helper

import kotlin.math.*

/**
 * The sigmoid function, used to calculate the activation of a neuron
 */
fun sigmoid(x : Double) = 1.0 / (1.0 + E.pow(-x))