#include <stdio.h>
int 
main() {
    FILE *garbage = fopen("./file.txt", "w");
    for (int j = 1; j <= 2000; ++j) {
	for (int i = 0; i < j; ++i) {
	    fputs("Ich will meine Hausaufgaben nicht machen!", garbage);
	}
	fputs("\n", garbage);
    }
    fclose(garbage);
    return 0;
}
