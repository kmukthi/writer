# Writer Implementation
Writer is a component that will you write strings to a target. The behavior of the writer is specified in the Writer abstract class. Using this abstract class, different kinds of writers can be implemented.

The difference in the writer is basically going to be in writing the content to a target and reading the content from a target. So they are the abtract methods that need to be implemented

## This repo has two types of writers
###### String Writer
Write strings to a variable.
###### File Writer
Write strings to a file

## The different kind of operations the writer can perform
- ###### Write - Write the content to a target(different for different writers)
- ###### Read - Read the content from a target(different for different writers)
- ###### Close - After closing, writer will not write anything to the targer
- ###### Lowercase - Convert the content to lower case
- ###### Uppercase - Convert the content to upper case
- ###### Stupid Remover - This replaces the word "*stupid*" (only in lower case) to "s*****"
- ###### Duplicate Remover - This removes consecutive duplicated words.


## Application
The app makes use of factory pattern to create the object that is needed. Navigate to *WriterApplication* file and you will see the main method.
The behavior of the writer is shown in the respective test files.
- FileWriterTest
- StringWriterTest
- WriterFactoryTest


