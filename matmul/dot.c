#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int vectors[argc-1];
    int sum = 0;
    for(int i = 1; i <= argc / 2; i++) {
        //printf("%d*%d\n",strtol(argv[i],NULL,10),strtol(argv[(argc / 2) + i],NULL,10));
        sum += strtol(argv[i],NULL,10) * strtol(argv[(argc / 2) + i],NULL,10);
    }
    //printf("Dot Product = %d\n", sum);
    printf("%d",sum);
    return sum;
}
