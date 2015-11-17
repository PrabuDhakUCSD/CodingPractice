#include<stdio.h>
#include<string.h>

int isMatch(char* pat, char* inp) {
    char skipchar;
    while((*pat)!='\0' && (*inp)!='\0') {
        if (*pat == '.') {
            if(*(pat+1) == '*') {
                pat+=2;

                while((*inp)!= '\0') {
                    if (isMatch(pat, inp)) {
                        return 1;
                    }
                    else {
                        inp++;
                    }
                }

                if ((*inp) == '\0' && (*pat)== '\0')
                    return 1;
                else
                    return 0;
            }
            else {
                pat++;
                inp++;
                continue;
            }
        }
        else {
            if (*(pat+1) == '*') {
                skipchar = *pat;
                pat+=2;

                while((*inp)!= '\0') {
                    if (isMatch(pat, inp)) {
                        return 1;
                    }
                    else {
                        if ((*inp) == skipchar) {
                            inp++;
                        }
                        else {
                            return 0;
                        }
                    }
                }
            }
            else {
                if (*pat != *inp)
                    return 0;

                pat++;
                inp++;
            }
        }
    }

    if ((*pat) =='\0' && (*inp) =='\0') {
        return 1;
    }
    else {
        return 0;
    }
}

int main(int argc, char** argv) {
    char* pat = argv[1];
    char* inp = argv[2];

    if (isMatch(pat,inp))
        printf("Match!");
    else
        printf("Does not match");
    return 0;
}
