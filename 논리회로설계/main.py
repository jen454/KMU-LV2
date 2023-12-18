def solution(minterm):
    answer = []
    PILIST = [[] for _ in range(minterm[0] + 1)]

    for i in range(2, len(minterm)):
        bin_num = format(minterm[i], "b").zfill(minterm[0])
        PILIST[bin_num.count("1")].append([bin_num, False]) # combined 판별 True or False

    for size in range(minterm[0]):
        Combine_PILIST = [[] for _ in range(minterm[0] - size)]  # 초기화
        for i in range(minterm[0] - size):
            for j in PILIST[i]:
                for k in PILIST[i + 1]:
                    if HD(j[0], k[0]):
                        pi = make_pi(j[0], k[0])
                        if pi not in [y[0] for x in Combine_PILIST for y in x]:
                            Combine_PILIST[pi.count("1")].append([pi, False])
                        j[1] = True
                        k[1] = True
        for i in range(len(PILIST)):
            for j in PILIST[i]:
                if not j[1]:
                    answer.append(j[0])
        if Combine_PILIST == []:
            break
        PILIST = Combine_PILIST

    answer.sort()
    result = [pi.replace("2", "-") for pi in answer]
    return result

def HD(a, b):
    hd_cnt = 0
    for i in range(len(a)):
        if a[i] != b[i]:
            hd_cnt += 1
        if hd_cnt > 1:
            return False
    return True

def make_pi(a, b):
    pi = ""
    for i in range(len(a)):
        if a[i] != b[i]:
            pi += "2"
        else:
            pi += a[i]
    return pi

print(solution([3,4,0,1,2,3]))
print(solution([3, 6, 0, 1, 2, 5, 6, 7]))
print(solution([4,4,0,2,12,13]))
print(solution([8,4,14,15,36,37]))