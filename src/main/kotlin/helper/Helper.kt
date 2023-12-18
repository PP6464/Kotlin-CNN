package helper

fun List<Double>.multiplyAll() : Double = reduce(Double::times)