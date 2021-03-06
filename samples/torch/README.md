# Torch demo

Trains a handwritten digit classifier using the [Torch](http://torch.ch) C backend.
Like other Torch clients, most prominently [PyTorch](http://pytorch.org),
this example is built on top of the 
[ATen C API](https://github.com/pytorch/pytorch/tree/master/aten),
showing how a Torch client for Kotlin/Native could look like.

## Installation

To build [ATen (Torch for C)](https://github.com/pytorch/pytorch/tree/master/aten), 
make sure you have Python 2.X and pyyaml installed:

    # macOS: if you don't have pip
    sudo easy_install pip
    # Linux: if you don't have pip
    apt-get -y install python-pip
    
    # if you don't have pyyaml
    sudo pip install pyyaml
    
Now

    ./downloadTorch.sh

will install it into `$HOME/.konan/third-party/torch` (if not yet done). 

To build use `../gradlew build` or `./build.sh`.

    ./downloadMNIST.sh

will download and unzip the [MNIST dataset](https://en.wikipedia.org/wiki/MNIST_database) of 
[70000 labeled handwritten digits](http://yann.lecun.com/exdb/mnist/) for training and testing a classifier.

Then run 

    ../gradlew run
    
Alternatively you can run the artifact directly through

    ./build/konan/bin/macbook/HelloTorch.kexe
    
You may need to specify `LD_LIBRARY_PATH` or `DYLD_LIBRARY_PATH` to `$HOME/.konan/third-party/torch/lib`
if the ATen dynamic library cannot be found.

Even on a CPU, training should only take some minutes, 
and you should observe a classification accuracy of about 95% on the test dataset.