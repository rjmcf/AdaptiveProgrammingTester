M = csvread('/Users/Rjmcf/Documents/Cambridge/Year 3/Personal Project/AdaptiveProgrammingTester/src/entryPoints/evaluationPerf.txt');
Nodes = M(1,2:end);
Attempts = M(2:end,1);
Data = M(2:end, 2:end);
[X, Y] = meshgrid(Nodes, Attempts);

clear title xlabel ylabel
[C,h] = contour(X,Y,Data);
clabel(C,h)
title('Performance as a function of N^o of attempts taken and N^o of extra nodes', 'FontSize', 14);
xlabel('Number of extra nodes', 'FontSize', 14) % x-axis label
ylabel('Number of attempts', 'FontSize', 14) % y-axis label

ax = gca;
ax.YTick = [1 2 3 4 5];
