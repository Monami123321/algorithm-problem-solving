#include <stdio.h>
#include <stddef.h>

int main(int argc, char const *argv[])
{
    int testCases, a, b;
    scanf("%d", &testCases);


    for (size_t i = 0; i < testCases; i++)
    {
        scanf("%d %d", &a, &b);
        printf("%d\n",a+b);
        
    }
    


    return 0;
}
