#include <stdio.h>
#include <stddef.h>
int main(int argc, char const *argv[])
{
    int t, a, b;
    scanf("%d", &t);

    for (size_t i = 1; i <= t; i++)
    {
        scanf("%d %d", &a, &b);
        printf("Case #%zu: %d\n",i,a+b);
    }

    return 0;
}
