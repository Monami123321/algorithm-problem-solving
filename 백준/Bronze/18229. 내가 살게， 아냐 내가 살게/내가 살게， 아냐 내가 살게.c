#include <stdio.h>
#include <stdlib.h>


int main() {
    int n, m, k;
    scanf("%d %d %d", &n, &m, &k);
    int **arr = (int **)malloc(n * sizeof(int *));
    for(int i = 0; i < n; ++i) {
        arr[i] = (int *)malloc((m + 1) * sizeof(int));
    }
    for(int i  = 0; i < n; ++i) {
        arr[i][0] = 0;
    }
    
    for(int i = 0; i < n; ++i) {
        for(int j = 1; j < m + 1; ++j) {
            scanf("%d", &arr[i][j]);
        }
    }
    for(int i = 1; i < m + 1; ++i) {
        for(int j = 0; j < n; ++j) {
            arr[j][i] += arr[j][i-1];
            if(arr[j][i] >= k) {
                printf("%d %d", j + 1, i);
                return 0;
            }
        }
    }
}