// https://leetcode.cn/problems/build-an-array-with-stack-operations/submissions/function buildArray(target: number[], n: number): string[] {
    const PUSH = 'Push', POP = 'Pop', sequnce: string[] = [];

    for (let idx = 0, i = 1; idx < target.length && i <= n; i++) {// idx < size of target
        sequnce.push(PUSH);
        if (target[idx] === i) {
            idx++;
        } else {
            sequnce.push(POP);
        }
    }
    return sequnce;
};