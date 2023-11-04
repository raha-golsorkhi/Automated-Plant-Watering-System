# Automated-Plant-Watering-System-
INTRODUCTION:
In this project, I created a smart plant watering system using Java and an Arduino board. I used essential libraries and APIs to establish a responsive connection with the board, enabling the system to water plants without the need for constant user involvement. This not only simplified plant care but also contributed to energy and time efficiency.

CONTEXT:
The primary goal of this project is to automate plant watering based on soil moisture levels. The Arduino OLED display provides real-time feedback on the soil condition, and when the soil is sufficiently moist, the system turns off the water pump. This automation feature is a significant advantage, as it allows the system to continuously monitor and care for the plant, adapting to its specific needs.

TECHNICAL REQUIREMENTS / SPECIFICATIONS:
This program must:
• Water the plant when the soil is dry or damp.
• Stop watering when soil is wet.
• Display Information of voltage of moisture sensor, soil and pump’s condition on OLED.
• Stop when button is pressed and terminate the code.
• Collect data infinitely and put it in HashMap.
• Give me a graph of sensor’s voltage/time and how watering is going.

APIs:
In this project, I used the Firmata4j API to establish a vital connection between my computer and the Arduino board. This connection allowed me to create an "myArduino" object linked to my computer's port, enabling me to receive data from sensors like the moisture sensor and buttons, and control devices like the pump and OLED screen by creating dedicated objects for each.
The Firmata4j API played a key role in the project, facilitating communication with the board and enabling actions based on sensor inputs.
To enhance the project's capabilities, I also used the Princeton StdLib, which provided a range of data and algorithms to process sensor data. This was particularly useful in my "GraphTask" class, where I created meaningful graphs based on the sensor data.
The underlying theme across these APIs was their ability to interact with the board, collect and process data, and use that data for tasks like generating graphs, displaying information, or controlling the pump, making the project both functional and dynamic.

EVENT LISTENER:
In my project, I employed the eventListener interface from Firmata4j to handle button-related actions. This functionality was implemented within my ButtonListener class. The primary role of this button was to serve as a means to gracefully terminate the code execution, effectively stopping the plant watering process. To ensure the proper operation of the pump when the button was pressed, I used an LED as a visual indicator, providing a feedback mechanism to confirm the pump's functionality.

HASHMAP:
I utilized a HashMap to collect and organize my data for graph creation. I named this HashMap "myPairs" and used it to pair the variable "i" with the sensor's data value.To draw the graph, I employed a foreach loop to go through each element in the HashMap and represented the data using asterisks ("*"). The HashMap continuously accumulated data as long as it received input from the sensor. For code refinement, I performed some necessary mathematical operations to process and transfer data from the HashMap to the graph, ensuring that the graphical representation accurately reflected the sensor's values.

COMPONENTS LIST:
What I used in my project:
• Moisture sensor: estimate the
amount of water in the soil
• MOSEF: a transistor used to switch or
amplify voltages in circuits.
• Pump
• Computer with source code
• OLED: Screen on Arduino
• Battery
• Plant
• Water
