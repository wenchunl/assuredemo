# assuredemo
Demo project illustrate how to use assured tool for restful api

This demo project built by eclipse 2022-03 (4.23.0) + junit + spring boot + rest assured

1. Install Spring Tools 4 (aka Spring Tool Suite 4) from Eclipse Marketplace ![image](https://user-images.githubusercontent.com/66583485/169986658-7391d846-f189-422c-bbb6-d2ada1128939.png)

2. New a spring boot starter project from the wizard. ![image](https://user-images.githubusercontent.com/66583485/169986886-fba711e9-6c3a-47e0-a598-59feaa8fca97.png)
3. Create the controller class (Which is the AUT(application under test)) 

@GetMapping(value = "/lotto")
	public @ResponseBody void lotto(HttpServletRequest request, HttpServletResponse response) {
		Winner win1 = new Winner();
		win1.setWinnerId(23);
		int[] temp = { 2, 45, 34, 23, 3, 5 };
		win1.setNums(temp);

		Winner win2 = new Winner();
		win2.setWinnerId(54);
		int[] temp2 = { 52, 3, 12, 11, 18, 22 };
		win2.setNums(temp2);

		Lotto lotto = new Lotto();
		lotto.setLottoId(5);
		int[] winningNumbers = { 2, 45, 34, 23, 7, 5, 3 };
		Winner[] wins = { win1, win2 };

		lotto.setWinningNumbers(winningNumbers);
		lotto.setWinnerList(wins);

		ObjectMapper obj = new ObjectMapper();
		String res = "No value provided by server";
		try {
			res = obj.writeValueAsString(lotto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setContentType("application/json");
		try {
			response.getWriter().write(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


4. Write the test method as the following: 
![image](https://user-images.githubusercontent.com/66583485/169987650-381fb8d3-4fc3-4abc-b5e0-650b0f57cd1c.png)

5. Right click the project, and select "Run as"->"Spring boot app" ![image](https://user-images.githubusercontent.com/66583485/169988030-afb429a0-f575-4d63-ac54-ced1e3f380b3.png)

now, we can first manually get the json response from browser. fill the url with : localhost:8081/lotto , and hit enter. 
![image](https://user-images.githubusercontent.com/66583485/169988452-56d441cd-e96f-4d34-bf4d-a87746014b49.png)

6. select the test case java file, and run as junit test. 
![image](https://user-images.githubusercontent.com/66583485/169988708-6087edf0-2ba8-48fd-b0aa-266acc511015.png)

7. We can see the two tests passed![image](https://user-images.githubusercontent.com/66583485/169989176-290c1e87-e56e-4f72-82c5-3ae14e264e70.png)

