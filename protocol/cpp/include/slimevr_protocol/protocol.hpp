#pragma once

#define ARDUINOSTL_M_H // Workaround to deal with <utility.h> missing in flatbuffers

// Some of the #defines from platformio conflict with the protocol's enum names.
// We fix that by temporarily undefining the conflicting #defines
#define __TMP_ESP8266 ESP8266
#undef ESP8266

// #define ARDUINOSTL_M_H to deal with <utility.h> missing in flatbuffers
#ifdef ARDUINOSTL_M_H
    #define __TMP_ARDUINOSTL_M_H ARDUINOSTL_M_H
#endif
#define ARDUINOSTL_M_H

// Actually include the generated code
#include "generated/all_generated.h"

// Undo the temp values and restore the originals
#define ESP8266 __TMP_ESP8266
#undef __TMP_ESP8266

#undef ARDUINOSTL_M_H
#ifdef __TMP_ARDUINOSTL_M_H
    #define ARDUINOSTL_M_H __TMP_ARDUINOSTL_M_H
    #undef __TMP_ARDUINOSTL_M_H
#endif
