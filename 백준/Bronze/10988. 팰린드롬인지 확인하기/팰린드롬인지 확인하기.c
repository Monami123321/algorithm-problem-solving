#include <stdio.h>

int main() {
    char arr[100];
    scanf("%s", arr);
    int len = strlen(arr);
    int index = 0;
    while(index < (len >> 1)) {
        if(arr[index] != arr[len - ++index]) {
            printf("0");
            return 0;
        } 
    }
    printf("1");
    return 0;
}