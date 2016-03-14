JFLAGS = -g
JC = javac
J = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Toolbar.java \
          ImageFrame.java \
          Model.java \
          ImageModel.java \
          ImageCollectionModel.java \
          ImageCollectionView.java \
          ImageView.java \
          RatingPanel.java \
          Footag.java 

default: classes

run: classes
	$(J) Footag
	 

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class