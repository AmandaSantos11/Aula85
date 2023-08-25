FROM openjdk:11

COPY src/main/java/org/example/Biblioteca.java .

RUN javac Biblioteca.java

CMD ["java", "Biblioteca"]