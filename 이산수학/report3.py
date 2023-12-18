def reflexive(matrix, elements):
    for i in range(len(elements)):
        if (not matrix[i][i]):
            return False
    return True

def symmetric(matrix, elements):
    for i in range(len(elements)):
        for j in range(len(elements)):
            if (matrix[i][j] != matrix[j][i]):
                return False
    return True

def transitive(matrix, elements):
    for i in range(len(elements)):
        for j in range(len(elements)):
            if (matrix[i][j]):
                for k in range(len(elements)):
                    if (matrix[j][k] and not matrix[i][k]):
                        return False
    return True

def solution(matrix, elements):
    if (reflexive(matrix,elements)):
        print("반사관계이다.")
    else: 
        print("반사관계가 아니다.")
    if (symmetric(matrix,elements)):
        print("대칭관계이다.")
    else: 
        print("대칭관계가 아니다.")
    if (transitive(matrix,elements)):
        print("추이관계이다.")
    else:
        print("추이관계가 아니다.")

def matrix_from_file(filename, elements):
    matrix = [[0 for j in range(len(elements))] for i in range(len(elements))]
    with open(filename, 'r') as file:
        for line in file:
            row, col = map(int, line.strip().split())
            matrix[row-1][col-1] = 1
    return matrix

while (True):
    filename = input()
    if (filename == "end"):
        break
    set_A = [1,2,3,4,5,6]
    matrix = matrix_from_file(filename,set_A)
    solution(matrix, set_A)