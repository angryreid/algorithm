function findOrder(numCourses: number, prerequisites: number[][]): number[] {
  let graph = new Array(numCourses);
  let indegree = new Array(numCourses).fill(0);
  let ans = [];
  let queue = [];

  prerequisites.forEach(prerequisite => {
      const [to, from] = prerequisite;
      indegree[to]++;
      if (!graph[from]) 
      graph[from] = [];
      graph[from].push(to);
  })

  for (let i = 0; i < numCourses; i++) {
      if (indegree[i] === 0) {
          queue.push(i);
      }
  }

  while (queue.length !== 0) {
      let course = queue.shift();
      ans.push(course);
      const nextCourses = graph[course]?.length || [];
      for (let i = 0; i < nextCourses; i++) {
          let to = graph[course][i];
          indegree[to]--;
          if (indegree[to] === 0) {
              queue.push(to);
          }
      }
  }
  if (ans.length !== numCourses) return [];
  return ans;
};