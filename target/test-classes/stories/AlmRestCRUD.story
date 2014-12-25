Given Login to ALM
When Get All Defects
Then Check that Status Code is 200 in GetResponse
Given Logout from ALM

Given Login to ALM
When Create defect
Then Check that Status Code is 201 in PostResponse
Given Logout from ALM

Given Login to ALM
When Create defect
When Get previously created defect
Then Check that Status Code is 200 in GetResponse
Given Logout from ALM

Given Login to ALM
When Create defect
When Update previously created defect
Then Check that Status Code is 200 in GetResponse
Given Logout from ALM

Given Login to ALM
When Create defect
When Delete previously created defect
Then Check that Status Code is 200 in GetResponse
Given Logout from ALM