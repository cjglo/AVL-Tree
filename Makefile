# Not very detailed or professional, this makefile exists purely to make my life easier testing

build:
	rm *.class
	javac TreeNode.java AVLTree.java TreeTester.java

run:
	java TreeTester
