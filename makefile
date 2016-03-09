JFLAGS = -g
JC = javac
J = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Toolbar.java \
        Footag.java 

default: classes

run: classes
	$(J) Footag
	 

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class