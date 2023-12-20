package helper

fun List<Double>.multiplyAll() : Double = reduce(Double::times)

fun emptyActivations(size : Long) = (0..<size).map { 0.0 }