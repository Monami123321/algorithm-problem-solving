#include <stdio.h>
int main(void) {
    char tmp[102];
    
    while(fgets(tmp,sizeof(tmp),stdin) != NULL) {
        printf("%s",tmp);
    }
    return 0;
}