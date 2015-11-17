#include <stdio.h>

int main() {
    int t = 0xFF;
    printf("%d", t);
    char* p = (char*)&t;
    
    printf("%X", *(p));
    //if (((void*)(*p)) == 0xDD)
    //    printf("Little endian");
    //else if(((void*)(*p)) == 0xAA)
    //    print("Big endian");
    //else
    //    printf("Confused");
    return 0;
}

