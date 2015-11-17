    #include<stdio.h>
    
    int main() {
    
        struct sample {
            int a;
            int b;
            double c;
            char y;
        };
    
        struct sample inst;
        struct sample* ptr1 = &inst;
        
        printf("%x\n", ptr1);    
        printf("%x\n", ptr1+1);    
        printf("size of struct: %d\n", (ptr1+1)-(ptr1));
        printf("size of struct: %d\n", (char*)(ptr1+1)-(char*)(ptr1));
        return 0;
    }
