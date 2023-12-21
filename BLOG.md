# Day 1

### Goals

- Implement Layer class and subclasses (InputLayer, DenseLayer and OutputLayer) ✅

### How did it go?

The implementation was conceptually straightforward, so could be completed in a short amount of time.

# Day 2

### Goals

- Implement the Sequential class:
    - Implement the constructor for the Sequential class ✅

### How did it go?

I found this goal quite simple because it was just implementing a constructor, and adding some basic assertions within
said constructor

# Day 3

### Goals

- Implement the Sequential class:
    - Implement the run method ✅
    - Save and load the model ✅
- Test the code so far

### How did it go?

Implementing the run method was a bit more difficult than the other goals before, because I finally had to start
computing activations,
but it was still quite straightforward. This is helpful for then implementing the training method, which is where I
expect this to get much more difficult.

Implementing the save and load methods were quite straightforward.

Testing the code so far went well. I tested the code by calling the run method on a Sequential model (see Main.kt for
tests) and it outputted a random answer each time, which is to be expected as the weights are randomly initialised and
the model hasn't been trained yet. It was impressive to see that the tests did not take much time to run, completing in
only ~83ms.