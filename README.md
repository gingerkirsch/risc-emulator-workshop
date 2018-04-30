# README #

This project represents an exercise of implementing an emulator of simplest RISC processor. It can be programmed in a very simple way: using commands composed of 4 digits, where first 2 digits would stand for an instruction to be executed and second 2 digits - a slot of memory on which we operate.

### What is this repository for? ###

* RISC processor emulator
* Version 1.0

### How do I get set up? ###

* Summary of set up

SBT, Scala 2.15. 
UI: node-js version 8
 scala-js as plugin, electron installed in npm
 
 npm install on project
 sbt fastOptJs to generate js from scala
 to start app - npm start

### What is the instruction set? ###
  00 -> "Empty",
  10 -> "Read",
  11 -> "Write",
  20 -> "Load",
  21 -> "Store",
  30 -> "Add",
  31 -> "Sub",
  32 -> "Div",
  33 -> "Mul",
  40 -> "Go",
  41 -> "GoNeg",
  42 -> "GoZero",
  43 -> "Halt"

### How do I code? ###
Place your instructions into text file, one instruction per line.
Example:

1013 - Read from IO into position 13

### Who do I talk to? ###

* sandra.sankova@gmail.com