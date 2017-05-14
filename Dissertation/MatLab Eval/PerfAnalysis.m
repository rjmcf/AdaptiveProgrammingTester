M = csvread('/Users/Rjmcf/Documents/Cambridge/Year 3/Personal Project/AdaptiveProgrammingTester/src/entryPoints/evaluationPerf.txt');
Nodes = M(1,2:end);
Attempts = M(2:end,1);
Data = M(2:end, 2:end);
[X, Y] = meshgrid(Nodes, Attempts);

clear title xlabel ylabel
[C,h] = contour(X,Y,Data);
hold on
clabel(C,h)
plot(0,4, 'r+')
text(0,4,'B  ','HorizontalAlignment','right', 'FontSize', 14, 'Color', 'r')
plot(7,2, 'm+')
text(7,2,'C  ','HorizontalAlignment','right', 'FontSize', 14, 'Color', 'm')
plot(0,2, 'b+')
text(0,2,'A  ','HorizontalAlignment','right', 'FontSize', 14, 'Color', 'b')
hold off
h = title('Performance as a function of number of attempts and extra nodes', 'FontSize', 14);
P = get(h,'Position');
set(h,'Position',[P(1) P(2)+0.1 P(3)])
xlabel('Number of extra nodes used', 'FontSize', 14) % x-axis label
ylabel('Number of attempts required', 'FontSize', 14) % y-axis label

ax = gca;
ax.YTick = [1 2 3 4 5];
