/*
 * Copyright 2020 Daniel Spiewak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cats.effect.testing.specs2

import cats.implicits._
import cats.effect._
import org.specs2.specification.BeforeAfterAll
import cats.effect.syntax.effect._
import scala.concurrent.duration._
import org.specs2.execute.{AsResult, Failure, Result}

trait CatsResourceIO[A] extends CatsResource[IO, A] with CatsIO {

  implicit def ResourceEffect: Effect[IO] = IO.ioEffect
  
  def resource: Resource[IO, A]

}