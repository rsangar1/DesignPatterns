#!/bin/bash +vx
#usage ./run <input> <Num Iterations> <Debug Value>
#It assumes that build file placed in src/build.xml
if test "$#" -ne 3; then
	echo "Wrong number of arguments!"
	echo "usage ./run <input> <Num Iterations> <Debug Value>"
else
	echo "ant run -buildfile src/build.xml -Darg0=$1 -Darg1=$2 -Darg2=$3"
	ant run -buildfile src/build.xml -Darg0=$1 -Darg1=$2 -Darg2=$3
fi
