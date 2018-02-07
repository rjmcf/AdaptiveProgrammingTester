y = csvread('/Users/Rjmcf/Documents/Cambridge/Year 3/Personal Project/AdaptiveProgrammingTester/src/entryPoints/evaluationDiff.txt');
x = 1:length(y);
plot(x,y,'x-');
%h = title('Rates of increase in difficulty for each question', 'FontSize', 16);
h = title('Increase in difficulty with number of correct solutions', 'FontSize', 16);
P = get(h,'Position');
set(h,'Position',[P(1) P(2)+0.3 P(3)])
% hold on;
% x = 0:length(y) + 3;
% y = 0.091 * x + 0.0;
% l1 = plot(x,y,'-');
% y = 0.067 * x + 0.66;
% l2 = plot(x,y,'-');
% y = 0.048 * x + 1.465;
% l3 = plot(x,y,'-');
xlabel('Number of correct solutions', 'FontSize', 14)
ylabel('Measured difficulty', 'FontSize', 14)
xlim([0 35])
ylim([0 3.2])
legend([l1 l2 l3], {'SquareExercise','FactorialExercise','AddArrayToNExercise'}, 'Location','northwest');