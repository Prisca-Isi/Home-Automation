int val;

int tempPin = 1;

int ledPin=7;


void setup()
{
Serial.begin(9600);
pinMode(ledPin, OUTPUT);  
}

void loop()
{
val = analogRead(tempPin);
float mv = ( val/1024.0)*5000; 
float cel = mv/10;
float farh = (cel*9)/5 + 32;

 if(cel>=20){
  digitalWrite(ledPin, HIGH);     // sets the Red LED on
  delay(2000);                     // waits for half a second
  digitalWrite(ledPin, LOW);      // sets the Red LED off
  delay(500); 
 }
Serial.print("TEMPRATURE = ");
Serial.print(cel);
Serial.print("*C");
Serial.println();
delay(3000);

/* uncomment this to get temperature in farenhite 
Serial.print("TEMPRATURE = ");
Serial.print(farh);
Serial.print("*F");
Serial.println();


*/
}
