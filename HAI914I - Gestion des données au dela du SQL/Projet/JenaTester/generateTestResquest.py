import fileinput


file_2M = "output_2M.csv"
file_500K = "output_500K.csv"


total_goal = 6000

result_goal_0 = 300
goal_1_statement = 700
goal_2_statement = 1500
goal_3_statement = 1500
goal_4_statement = 2000

output_queries = []

if __name__ == "__main__":
    for line in fileinput.input([str(file_2M)]):
        data = line.split(",")
        query = data[0]
        nbResult = int(data[1])
        nbStatement = int(data[2])

        if query not in output_queries:
            if nbResult == 0 and result_goal_0 > 0:
                output_queries.append(query)
                result_goal_0 -= 1
                total_goal -= 1

            if nbResult > 0 and nbStatement == 1 and goal_1_statement > 0:
                output_queries.append(query)
                goal_1_statement -= 1          
                total_goal -= 1

            if nbResult > 0 and nbStatement == 2 and goal_2_statement > 0:
                output_queries.append(query)
                goal_2_statement -= 1   
                total_goal -= 1

            if nbResult > 0 and nbStatement == 3 and goal_3_statement > 0:
                output_queries.append(query)
                goal_3_statement -= 1   
                total_goal -= 1

            if nbResult > 0 and nbStatement == 4 and goal_4_statement > 0:
                output_queries.append(query)
                goal_4_statement -= 1   
                total_goal -= 1
                
    f = open("all.queryset","w+")
    for query in output_queries:
        f.write(str(query) + "\n")
    f.close()
    print(len(output_queries))
    print("total_goal : " + str(total_goal))
    print("result_goal_0 : " + str(result_goal_0))
    print("goal_1_statement : " + str(goal_1_statement))
    print("goal_2_statement : " + str(goal_2_statement))
    print("goal_3_statement : " + str(goal_3_statement))
    print("goal_4_statement : " + str(goal_4_statement))