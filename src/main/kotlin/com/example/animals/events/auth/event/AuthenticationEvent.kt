package com.example.animals.events.auth.event

import java.util.UUID

class AuthenticationEvent (source: Any, val uuid: UUID?, val action: String)