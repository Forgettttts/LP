all: Tarea2

Tarea2: main.o heap.o
	gcc -o Tarea2  main.o heap.o

main.o: main.c heap.h
	gcc -W -Wall -c main.c

heap.o: heap.c heap.h
	gcc -W -Wall -c heap.c

clean:
	rm -f Tarea2 *.o