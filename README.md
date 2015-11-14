# candidate-elimination-algorithm
implementation of candidate elimination algo in java.

## pre-requisites
java, candidate elimination algorithm

## references

Machine Learning by Tom Mitchell

Classes used are :

● CandidateElimination

● Hypothesis

● TrainingData

● ReadFromFile

● TestClass

CandidateElimination : most important of all of them, major portion of the code is present in form of various functions like positiveEncounter, negativeEncounter , finding minmal specification set and generalization too.

Hypothesis : describes about the hypothesis structure and data regarding the attributes used and functions like is Consistent and isMoreGeneralThan is present etc

TrainingData : structure of training data i.e, Hypothesis and target value.

ReadFromFile: class to read data from input file for training purposes and can be extended for testing too.

TestClass : main function is written here and program starts execution from it.

Major functions used are:

● minimalSpecialization

● minimalGeneralization

● moreGeneralThan

● consistent

minimalSpecialization : given hypothesis, training example it deduces all the minimal specification of hypothesis which are consistent with training example.

minimalGeneralization : given hypothesis, training example it deduces all the minimal generalizations of hypothesis which are consistent with training example.

moreGeneralThan: determines whether a given hypothesis is general than other hypothesis.

consistent: tells us whether a hypothesis is consistent with training example.

getVersionSpace: it uses general and specific boundaries to generate version space.

