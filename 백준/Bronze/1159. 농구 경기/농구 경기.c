#include <stdio.h>
int main() {
    int n;
    int visited[26] = {0};
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        char arr[30];
        scanf("%s", arr);
        ++visited[arr[0] -97];
    }
    char ans[27];
    int index = 0;
    for(int i = 0; i < 26; ++i) {
        if(visited[i] > 4) {
            ans[index++] = 97 + i;
        }
    }
    ans[index] = '\0';
    if(ans[0] == '\0') {
        printf("PREDAJA");
    } else {
        printf("%s",ans);
    }
    return 0;
}