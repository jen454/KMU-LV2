.text
.globl main
main:
    addi $t1, $0, -2147483648 # later, in more detail
    subu $t2, $0, $t1 # overflow