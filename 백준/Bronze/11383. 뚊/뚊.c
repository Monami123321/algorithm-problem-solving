#include <stdio.h>

int main() {
    int n, m;
    scanf("%d %d", &n, &m);
    char arr[n][m];
    for(int i = 0; i < n; ++i) {
        for(int j = 0; j < m; ++j) {
             scanf(" %c", &arr[i][j]);
        }
    }
    char arr2[n][m << 1];
    
    for(int i = 0; i < n; ++i) {
        for(int j = 0; j < m << 1; ++j) {
            scanf(" %c", &arr2[i][j]);
        }
    }
    for(int i = 0; i < n; ++i) {
        for(int j = 0; j < m; ++j) {
            if(arr[i][j] != arr2[i][j << 1] || arr[i][j] != arr2[i][j << 1 | 1]) {
                printf("Not Eyfa");
                return 0;
            }
        }
    }
    printf("Eyfa");
    return 0;
}